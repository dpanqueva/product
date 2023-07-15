package com.electronic.commerce.product;

import com.electronic.commerce.product.infraestructure.dto.PriceDTO;
import com.electronic.commerce.product.infraestructure.exceptions.ExceptionErrorHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @InjectMocks
    private ExceptionErrorHandler exceptionHandlerController;

    @Test
    void testGetPrice10Day14() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetPrice16Day14() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetPrice21Day14() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetPrice10Day15() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetPrice21Day16() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetPriceBadRequest() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate=2{applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testGetPriceNotFound() {
        // Configurar los parámetros de entrada
        LocalDateTime applicationDate = LocalDateTime.of(2027, 6, 16, 21, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        // Realizar la llamada HTTP al endpoint del controlador
        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?applicationDate={applicationDate}&productId={productId}&brandId={brandId}",
                PriceDTO.class,
                applicationDate,
                productId,
                brandId
        );

        // Verificar el resultado
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testInternalServerExceptionHandler() {
        Exception exception = new Exception("Unexpected error");
        ResponseEntity<Map<String, Object>> responseEntity = exceptionHandlerController.internalServerException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

        Map<String, Object> response = responseEntity.getBody();
        assertEquals("UPS! Unexpected error, contact system administrator", response.get("Message"));
    }
}
