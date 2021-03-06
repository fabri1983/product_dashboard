package org.fabri1983.eshopping.product.dashboard.api.controller;

import static org.fabri1983.eshopping.product.dashboard.util.HttpBearerRequestPostProcessor.httpBearer;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.fabri1983.eshopping.product.dashboard.util.ProductsOnPhaseCreation;
import org.fabri1983.eshopping.product.dashboard.util.ProductsOnPhaseUpdate;
import org.fabri1983.eshopping.product.dashboard.view.ProductCreateView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test", "repository-jpa"})
@TestPropertySource(locations = "classpath:test.properties")
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Given a ProductsController.")
public class ProductsControllerTest {
    
	@Autowired
    private MockMvc mockMvc;
    
    @Value("${security.jwt.client-id}")
    private String oauth2ClientId;
    
    @Value("${security.jwt.client-secret}")
    private String oauth2Secret;
    
    @Value("${security.jwt.grant-type}")
    private String grantType;
    
    private String adminUsername = "jane.diaz";
    private String adminPass = "abc123456";
    private String accessToken;
    
    @BeforeEach
    public void before() throws Exception {
    	accessToken = obtainAccessToken(adminUsername, adminPass);
    }
    
    private String obtainAccessToken(String username, String password) throws Exception {
  	  
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("username", username);
        params.add("password", password);
     
        ResultActions result = mockMvc.perform(
        		post("/auth/jwt")
		            .params(params)
		            .with(httpBasic(oauth2ClientId, oauth2Secret))
		            .accept(MediaType.APPLICATION_JSON_UTF8)
        		)
		        .andExpect(status().isOk())
		        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
     
        String resultString = result.andReturn().getResponse().getContentAsString();
     
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

	@Test
	@DisplayName("When no JWT in header. When GET /products (secured). Then HTTP Status Unauthorized (401).")
	@Order(-2)
	public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
	    mockMvc
	    	.perform(
	    		get("/products")
	    	)
	    	.andExpect(status().isUnauthorized());
	}

	@Test
	@Disabled
	@DisplayName("When GET /products. Then CORS headers match.")
	@Order(-1)
	public void givenARequest_whenResponse_thenCORSheadersMatch() throws Exception {
		mockMvc
			.perform(
				get("/products")
					.with(httpBearer(accessToken))
					.header(HttpHeaders.ORIGIN, "localhost")
					.header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET")
			)
			.andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*"))
			.andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, OPTIONS, DELETE"))
			.andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*"))
			.andExpect(header().string(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600"));
	}

    @Test
    @DisplayName("When POST on /products. Then HTTP Status Created (201).")
    @Order(1)
    public void createProducts() throws Exception {
        
        addProduct(ProductsOnPhaseCreation.product1())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product2())
    		.andExpect(status().isCreated());
        
        addProduct(ProductsOnPhaseCreation.product3())
    		.andExpect(status().isCreated());
        
        addProduct(ProductsOnPhaseCreation.product4())
    		.andExpect(status().isCreated());
        
        addProduct(ProductsOnPhaseCreation.product5())
    		.andExpect(status().isCreated());
        
        addProduct(ProductsOnPhaseCreation.product6())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product7())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product8())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product9())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product10())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product11())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product12())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product13())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product14())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product15())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product16())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product17())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product18())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product19())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product20())
    		.andExpect(status().isCreated());

        addProduct(ProductsOnPhaseCreation.product21())
        	.andExpect(status().isCreated());
    }

    private ResultActions addProduct(ProductCreateView prod) throws Exception {
    	 return mockMvc
    	 	.perform(
                 post("/products")
                 	.with(httpBearer(accessToken))
                 	.contentType(MediaType.APPLICATION_JSON_UTF8)
                 	.content(asJsonString(prod))
     		);
	}

    @Test
    @DisplayName("When POST on /products with existing id. Then HTTP Status Bad Request (400).")
    @Order(2)
    public void createProductWithExistingId() throws Exception {
    	/**
    	 * Create product with existing id 1
    	 */ 
        ProductCreateView prod = ProductCreateView.builder()
			.id(1L)
    		.version(1L)
			.name("Dressing Gown")
			.category("Underwear")
			.retailPrice(303.0)
			.discountedPrice(251.49)
			.availability(true)
			.build();
        
        mockMvc
        	.perform(
                post("/products")
                	.with(httpBearer(accessToken))
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(asJsonString(prod))
        	)
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    @DisplayName("When PUT on /products/6 with new retailPrice. Then HTTP Status OK (200) and product is updated.")
    @Order(3)
    public void updateProductRetailPrice() throws Exception {
        /**
         * Update retail price of a product with id 6
         *
         * The request body is:
         * {
         *     "retail_price": 325.45,
         *     "version": 1
         * }
         */
        String json = "{\"retail_price\": 325.45, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(6L)
        		.version(2L)
    			.name("Shawl")
    			.category("Accessories")
    			.retailPrice(325.45)
    			.discountedPrice(260.36)
    			.availability(true)
    			.build();
        
        mockMvc
        	.perform(
		   		put("/products/6")
		   			.with(httpBearer(accessToken))
           			.contentType(MediaType.APPLICATION_JSON_UTF8)
           			.content(json)
           	)
           .andExpect(status().isOk())
           .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
           .andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When PUT on /products/10 with new discountedPrice. Then HTTP Status OK (200) and product is updated.")
    @Order(4)
    public void updateProductDiscountPrice() throws Exception {
    	/**
         * Update discount price of a product with id 10
         *
         * The request body is:
         * {
         *     "discounted_price": 227.2,
         *     "version": 1
         * }
         */
        String json = "{\"discounted_price\": 227.2, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(10L)
        		.version(2L)
    			.name("Cufflinks")
    			.category("Accessories")
    			.retailPrice(284.0)
    			.discountedPrice(227.2)
    			.availability(true)
    			.build();
        
        mockMvc
			.perform(
				put("/products/10")
					.with(httpBearer(accessToken))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When PUT on /products/2 with new availability. Then HTTP Status OK (200) and product is updated.")
    @Order(5)
    public void updateProductAvailability() throws Exception {
        /**
         * Update availability of a product with id 2
         *
         * The request body is:
         * {
         *     "availability": false,
         *     "version": 1
         * }
         */
        String json = "{\"availability\": false, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(2L)
        		.version(2L)
    			.name("Shoes")
    			.category("Footwear")
    			.retailPrice(150.0)
    			.discountedPrice(123.0)
    			.availability(false)
    			.build();
        
        mockMvc
        	.perform(
				put("/products/2")
					.with(httpBearer(accessToken))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When PUT on /products/12 with new retailPrice and discountedPrice values. Then HTTP Status OK (200) and product is updated.")
    @Order(6)
    public void updateProductRetailAndDiscountPrice() throws Exception {
        /**
         * Update retail and discount price of a product with id 12
         *
         * The request body is:
         * {
         *     "retail_price": 350.0,
         *     "discounted_price": 283.5,
         *     "version": 1
         * }
         */
        String json = "{\"retail_price\": 350.0, \"discounted_price\": 283.5, \"availability\": true, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(12L)
        		.version(2L)
    			.name("Poncho")
    			.category("Accessories")
    			.retailPrice(350.0)
    			.discountedPrice(283.5)
    			.availability(true)
    			.build();
        
        mockMvc
	    	.perform(
				put("/products/12")
					.with(httpBearer(accessToken))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When PUT on /products/19 with new retailPrice, discountedPrice, and availability values. Then HTTP Status OK (200) and product is updated.")
    @Order(7)
    public void updateProductRetailPriceAndAvailability() throws Exception {
        /**
         * Update retail price and availability of a product with id 19
         *
         * The request body is:
         * {
         *     "retail_price": 125.0,
         *     "discounted_price": 100.0,
         *     "availability": false,
         *     "version": 1
         * }
         */
        String json = "{\"retail_price\": 125.0, \"discounted_price\": 100.0, \"availability\": false, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(19L)
        		.version(2L)
    			.name("Suit")
    			.category("Full Body Outfits")
    			.retailPrice(125.0)
    			.discountedPrice(100.0)
    			.availability(false)
    			.build();
        
        mockMvc
	    	.perform(
				put("/products/19")
					.with(httpBearer(accessToken))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    /**
     * It tests updating discount price and availability of a product
     *
     * @throws Exception
     */
    @Test
    @DisplayName("When PUT on /products/20 with new discountedPrice and availability values. Then HTTP Status OK (200) and product is updated.")
    @Order(8)
    public void updateProductDiscountPriceAndAvailability() throws Exception {
        /**
         * Update discount price and availability of a product with id 20
         *
         * The request body is:
         * {
         *     "discounted_price": 200.0,
         *     "availability": false,
         *     "version": 1
         * }
         */
        String json = "{\"discounted_price\": 200.0, \"availability\": false, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(20L)
        		.version(2L)
    			.name("Catsuit")
    			.category("Full Body Outfits")
    			.retailPrice(158.0)
    			.discountedPrice(200.0)
    			.availability(false)
    			.build();
        
        mockMvc
	    	.perform(
				put("/products/20")
					.with(httpBearer(accessToken))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When PUT on /products/13 with new retailPrice, discountedPrice, and availability values. Then HTTP Status OK (200) and product is updated.")
    @Order(9)
    public void updateProductRetailPriceDiscountPriceAndAvailability() throws Exception {
        /**
         * Update retail price, discount price and availability of a product with id 13
         *
         * The request body is:
         * {
         *     "retail_price": 500.0,
         *     "discounted_price": 450.0,
         *     "availability": false,
         *     "version": 1
         * }
         */
        String json = "{\"retail_price\": 500.0, \"discounted_price\": 450.0, \"availability\": false, \"version\": 1}";

        /**
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(13L)
        		.version(2L)
    			.name("Cummerbund")
    			.category("Accessories")
    			.retailPrice(500.0)
    			.discountedPrice(450.0)
    			.availability(false)
    			.build();
        
        mockMvc
        	.perform(
        		put("/products/13")
					.with(httpBearer(accessToken))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When PUT on /products/25 with new values of inexistent id. Then HTTP Status Bad Request (400).")
    @Order(10)
    public void updateAvailabilityOfNonExistingProduct() throws Exception {
        /**
         * Update availability of a non existing product with id 25
         *
         * The request body is:
         * {
         *     "availability": true,
         *     "version": 1
         * }
         */
        String json = "{\"availability\": true, \"version\": 1}";

        mockMvc
        	.perform(
                put("/products/25")
        			.with(httpBearer(accessToken))
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(json)
    		)
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    @DisplayName("When GET on /products/2. Then HTTP Status OK (200).")
    @Order(11)
    public void findProductById() throws Exception {
    	/**
    	 * Find product by id.
    	 * 
         * The response body is:
         */
        ProductCreateView expectedProd = ProductCreateView.builder()
    			.id(2L)
        		.version(2L)
    			.name("Shoes")
    			.category("Footwear")
    			.retailPrice(150.0)
    			.discountedPrice(123.0)
    			.availability(false)
    			.build();
        
        mockMvc.perform(
        		get("/products/2")
        			.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProd), true));
    }

    @Test
    @DisplayName("When GET on /products/25 of inexistent id. Then HTTP Status Not Found (404).")
    @Order(12)
    public void findProductByNonExistingId() throws Exception {
        /**
         * Find product by non-existing id 25
         */
        mockMvc
        	.perform(
        		get("/products/25")
        			.with(httpBearer(accessToken))
        	)
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    @DisplayName("When GET on /products?category=Accessories. Then HTTP Status OK (200) and 6 products are returned.")
    @Order(13)
    public void findProductsByCategory() throws Exception {
        /**
         * Find products belonging to Accessories category
         *
         * The request response is:
         */
        List<ProductCreateView> expectedProds = new ArrayList<>(6);
        expectedProds.add(ProductsOnPhaseUpdate.product1());
        expectedProds.add(ProductsOnPhaseUpdate.product10());
        expectedProds.add(ProductsOnPhaseUpdate.product6());
        expectedProds.add(ProductsOnPhaseUpdate.product12());
        expectedProds.add(ProductsOnPhaseUpdate.product7());
        expectedProds.add(ProductsOnPhaseUpdate.product13());
        
		mockMvc.perform(
				get("/products?category=Accessories")
					.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProds), true));
    }

    @Test
    @DisplayName("When GET on /products?category=Swimwear of inexistent category. Then HTTP Status OK (200) and an empty list is returned.")
    @Order(14)
    public void findProductsByNonExistingCategory() throws Exception {
        /**
         * Find products belonging to Swimwear category
         *
         * The request response is:
         * []
         */
        String res = "[]";

		mockMvc.perform(
				get("/products?category=Swimwear")
					.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(res, true));
    }

    @Test
    @DisplayName("When GET on /products?category=Full%20Body%20Outfits&availability=1. Then HTTP Status OK (200) and 6 products are returned.")
    @Order(15)
    public void findProductsByCategoryAndAvailabilityTrue() throws Exception {
        /**
         * Find products belonging to a given category and with availability
         *
         * The response is:
         */
        String res = "[" + 
        		"    {" + 
        		"        \"id\": 14," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Dress\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 175.0," + 
        		"        \"discounted_price\": 140.0," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 5," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Ball Gown\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 337.0," + 
        		"        \"discounted_price\": 272.97," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 1," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Dressing Gown\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 303.0," + 
        		"        \"discounted_price\": 251.49," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 3," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Nightgown\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 307.0," + 
        		"        \"discounted_price\": 254.81," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 17," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Tailcoat\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 307.0," + 
        		"        \"discounted_price\": 254.81," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 9," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Overalls\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 374.0," + 
        		"        \"discounted_price\": 321.64," + 
        		"        \"availability\": true" + 
        		"    }" + 
        		"]";

        mockMvc.perform(
        		get("/products?category=Full%20Body%20Outfits&availability=1")
					.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(res, true));
    }

    
    @Test
	@DisplayName("When GET on /products?category=Full%20Body%20Outfits&availability=0. Then HTTP Status OK (200) and 4 products are returned.")
	@Order(16)
	public void findProductsByCategoryAndAvailabilityFalse() throws Exception {
	    /**
	     * Find products belonging to a given category and with availability
	     *
	     * The response is:
	     */
	    List<ProductCreateView> expectedProds = new ArrayList<>(6);
        expectedProds.add(ProductsOnPhaseUpdate.product19());
        expectedProds.add(ProductsOnPhaseUpdate.product21());
        expectedProds.add(ProductsOnPhaseUpdate.product16());
        expectedProds.add(ProductsOnPhaseUpdate.product20());
        
		mockMvc
			.perform(
				get("/products?category=Full%20Body%20Outfits&availability=0")
					.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(asJsonString(expectedProds), true));
	}

	@Test
	@DisplayName("When GET on /products?category=Swimwear&availability=1. Then HTTP Status OK (200) and an empty list is returned.")
    @Order(17)
    public void findProductsByNonExistingCategoryAndAvailability() throws Exception {
        /**
         * Find products belonging to a given category and with availability
         *
         * The request response is:
         * []
         */
        String res = "[]";

		mockMvc
			.perform(
				get("/products?category=Swimwear&availability=1")
					.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(res, true));
    }

    @Test
    @DisplayName("When GET on /products. Then HTTP Status OK (200) and 21 products are returned.")
    @Order(18)
    public void findAllProducts() throws Exception {
        /**
         * Find all products
         *
         * The response is:
         */
        String res = "[" + 
        		"    {" + 
        		"        \"id\": 1," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Dressing Gown\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 303.0," + 
        		"        \"discounted_price\": 251.49," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 2," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Shoes\"," + 
        		"        \"category\": \"Footwear\"," + 
        		"        \"retail_price\": 150.0," + 
        		"        \"discounted_price\": 123.0," + 
        		"        \"availability\": false" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 3," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Nightgown\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 307.0," + 
        		"        \"discounted_price\": 254.81," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 4," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Boots\"," + 
        		"        \"category\": \"Footwear\"," + 
        		"        \"retail_price\": 162.0," + 
        		"        \"discounted_price\": 132.84," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 5," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Ball Gown\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 337.0," + 
        		"        \"discounted_price\": 272.97," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 6," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Shawl\"," + 
        		"        \"category\": \"Accessories\"," + 
        		"        \"retail_price\": 325.45," + 
        		"        \"discounted_price\": 260.36," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 7," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Belt\"," + 
        		"        \"category\": \"Accessories\"," + 
        		"        \"retail_price\": 471.0," + 
        		"        \"discounted_price\": 419.19," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 8," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Kaftan\"," + 
        		"        \"category\": \"Accessories\"," + 
        		"        \"retail_price\": 237.0," + 
        		"        \"discounted_price\": 215.67," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 9," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Overalls\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 374.0," + 
        		"        \"discounted_price\": 321.64," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 10," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Cufflinks\"," + 
        		"        \"category\": \"Accessories\"," + 
        		"        \"retail_price\": 284.0," + 
        		"        \"discounted_price\": 227.2," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 11," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Cargos\"," + 
        		"        \"category\": \"Bottoms\"," + 
        		"        \"retail_price\": 498.0," + 
        		"        \"discounted_price\": 428.28," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 12," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Poncho\"," + 
        		"        \"category\": \"Accessories\"," + 
        		"        \"retail_price\": 350.0," + 
        		"        \"discounted_price\": 283.5," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 13," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Cummerbund\"," + 
        		"        \"category\": \"Accessories\"," + 
        		"        \"retail_price\": 500.0," + 
        		"        \"discounted_price\": 450.0," + 
        		"        \"availability\": false" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 14," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Dress\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 175.0," + 
        		"        \"discounted_price\": 140.0," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 15," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Trainers\"," + 
        		"        \"category\": \"Footwear\"," + 
        		"        \"retail_price\": 228.0," + 
        		"        \"discounted_price\": 184.68," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 16," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Tracksuit\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 471.0," + 
        		"        \"discounted_price\": 423.9," + 
        		"        \"availability\": false" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 17," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Tailcoat\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 307.0," + 
        		"        \"discounted_price\": 254.81," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 18," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Vest\"," + 
        		"        \"category\": \"Tops\"," + 
        		"        \"retail_price\": 446.0," + 
        		"        \"discounted_price\": 392.48," + 
        		"        \"availability\": true" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 19," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Suit\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 125.0," + 
        		"        \"discounted_price\": 100.0," + 
        		"        \"availability\": false" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 20," + 
        		"        \"version\": 2," + 
        		"        \"name\": \"Catsuit\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 158.0," + 
        		"        \"discounted_price\": 200.0," + 
        		"        \"availability\": false" + 
        		"    }," + 
        		"    {" + 
        		"        \"id\": 21," + 
        		"        \"version\": 1," + 
        		"        \"name\": \"Dungarees\"," + 
        		"        \"category\": \"Full Body Outfits\"," + 
        		"        \"retail_price\": 437.0," + 
        		"        \"discounted_price\": 362.71," + 
        		"        \"availability\": false" + 
        		"    }" + 
        		"]";

        mockMvc
        	.perform(
        		get("/products")
        			.with(httpBearer(accessToken))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(content().json(res, true));
    }

	/**
	 * Converts a Java object into JSON representation.
	 */
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
