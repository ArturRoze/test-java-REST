package com.app.controller;

import com.app.domain.RequestUrl;
import com.app.model.DocumentEntity;
import com.app.repository.DocumentRepository;
import com.app.service.RequestSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RequestControllerTest {

    private static final String JSON = "{\"data\": [{\"hash\": \"md5:aa8f3e480ef09f68a3ba29d38526a54d\", \"format\": \"image/jpeg\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/f104698a64f64bdf8142f7e11df74dd2?KeyID=1331dc52&Signature=oi3cRoqISdyAb4f0wEM%252B43P8Mn1eh19YH%2FGwQkoHWlLDnQWWwFhZeXGvZStKoaJ8yDh%252B5JRy%252BTm4UNyzetDoCQ%253D%253D\", \"title\": \"19WII9x.jpg\", \"documentOf\": \"tender\", \"datePublished\": \"2018-11-15T10:46:48.083543+02:00\", \"dateModified\": \"2018-11-15T10:46:48.083564+02:00\", \"id\": \"219c45e36e4548f4963a484642420478\"}, {\"hash\": \"md5:dcc8b429838b29c8c6bbbd565b1f9b45\", \"format\": \"image/png\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/010690c6dba24402851d4e40fea90eb5?KeyID=1331dc52&Signature=RT7pybVmIlXm3QA2yOTbFyxtKtUzdeyemepwOAgbtqSeHz66x2dlhx%2FVnUX83dIo6leJzmhCJsUNVldMkwjMAw%253D%253D\", \"title\": \"zak_fb.png\", \"documentOf\": \"change\", \"datePublished\": \"2018-11-15T10:56:40.740846+02:00\", \"documentType\": \"contractAnnexe\", \"dateModified\": \"2018-11-15T10:56:40.740870+02:00\", \"relatedItem\": \"a45ec75e09b7461aaa7218d66b23f018\", \"id\": \"b3f936cd9e214387881aecdbdcc1aeff\"}, {\"hash\": \"md5:aa8f3e480ef09f68a3ba29d38526a54d\", \"language\": \"uk\", \"format\": \"image/jpeg\", \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/5bdfd8cefd634da988084378da57f306?KeyID=1331dc52&Signature=ak8O%2FooCoP2yTootrSk1kLamJAmhd%252BUCPHIvh6VrMGZPnk7n3gn0pygPvCs1mK9kTYEd93ubaDiEyHQbzpNIBw%253D%253D\", \"title\": \"19WII9x.jpg\", \"documentOf\": \"contract\", \"datePublished\": \"2018-11-15T11:22:51.416943+02:00\", \"dateModified\": \"2018-11-15T11:22:51.416995+02:00\", \"id\": \"44c098109cd2496880d7943e3921d80f\"}]}";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DocumentRepository documentRepository;

    @MockBean
    RequestSender requestSender;

    @Test
    public void saveAndUpdate() {

        //arrange
        DocumentEntity document = documentRepository.getById("44c098109cd2496880d7943e3921d80f");
        if (document != null)
            documentRepository.delete(document.getIdDb());

        String url = "https://test.com/";
        when(requestSender.send(url)).thenReturn(JSON);

        RequestUrl requestUrl = new RequestUrl(url);

        //action
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/documents/save", HttpMethod.POST, new HttpEntity<>(requestUrl), new ParameterizedTypeReference<Void>() {
        });

        //assert
        assertEquals(200, responseEntity.getStatusCodeValue());

        verify(requestSender).send(url);

        document = documentRepository.getById("44c098109cd2496880d7943e3921d80f");
        assertNotNull(document);

    }
}