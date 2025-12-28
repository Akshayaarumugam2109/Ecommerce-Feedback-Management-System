package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

//DAY 3 
@Autowired
    private MockMvc mockMvc;


@Test
@Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
	@Order(2)

    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
	@Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
	@Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }  


	//Day 4 Testcases

	@Test
	@Order(5)
    void Day4_test_CategoryModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Category.java").isFile());
    }

	@Test
	@Order(6)
    void Day4_test_ProductModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Product.java").isFile());
    }

	@Test
	@Order(7)

    void Day4_test_Feedback_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Feedback.java").isFile());
    }

	@Test
	@Order(8)
    void Day4_test_Rating_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Rating.java").isFile());
    }

	@Test
	@Order(9)
    void Day4_test_User_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/User.java").isFile());
    }

@Test
@Order(10)
void Day4_test_Product_Has_Entity_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.model.Product");
        Class<?> annotation = Class.forName("jakarta.persistence.Entity");

        assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Entity annotation is missing on Product class");

    } catch (ClassNotFoundException e) {
        fail("❌ Product class not found.");
    } catch (Exception e) {
        fail("❌ Unable to check @Entity annotation on Product.");
    }
}

@Test
@Order(11)

void test_Product_Has_Id_Annotation_On_Field() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.model.Product");
        Class<?> idAnnotation = Class.forName("jakarta.persistence.Id");

        boolean found = false;

        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent((Class<? extends Annotation>) idAnnotation)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No field in Product class is annotated with @Id");

    } catch (ClassNotFoundException e) {
        fail("❌ Product class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Id annotation in Product class.");
    }
}

	//Day 5 Tetscases
	@Test
	@Order(12)

    void Day5_testCategoryRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/CategoryRepo.java").isFile());
    }

	@Test
	@Order(13)
    void Day5_testProductRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/ProductRepo.java").isFile());
    }

	@Test
	@Order(14)
    void Day5_testFeedbackRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/FeedbackRepo.java").isFile());
    }


	@Test
	@Order(15)
    void Day5_testRatingRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/RatingRepo.java").isFile());
    }

	@Test
	@Order(16)
    void Day5_testUserRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/UserRepo.java").isFile());
    }


	@Test
	@Order(17)
    void Day5_test_ProductRepo_Has_Repository_Annotation() {
        try {
            // Load ProductRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.ProductRepo");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on ProductRepo class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ ProductRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on ProductRepo.");
        }
    }


	@Test
	@Order(18)
    void Day5_test_CategoryRepo_Has_Repository_Annotation() {
        try {
            // Load ProductRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.CategoryRepo");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on CategoryRepo class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on CategoryRepo.");
        }
    }


	@Test
	@Order(19)
    void Day5_test_FeedbackRepo_Has_Repository_Annotation() {
        try {
            // Load FeedbackRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.FeedbackRepo");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on FeedbackRepo class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ FeedbackRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on FeedbackRepo.");
        }
    }


	@Test
	@Order(20)
    void Day5_test_RatingRepo_Has_Repository_Annotation() {
        try {
            // Load RatingRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.RatingRepo");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on RatingRepo class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ RatingRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on RatingRepo.");
        }
    }


	@Test
	@Order(21)
    void Day5_test_UserRepo_Has_Repository_Annotation() {
        try {
            // Load UserRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.UserRepo");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on UserRepo class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ UserRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on UserRepo.");
        }
    }




	@Test
	@Order(22)
    void Day6_test_CategoryController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/CategoryController.java").isFile());
    }


	@Test
	@Order(23)
    void Day6_test_ProductController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/ProductController.java").isFile());
    }

	@Test
	@Order(24)
    void Day6_test_FeedbackController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/FeedbackController.java").isFile());
    }

	
	@Test
	@Order(25)
    void Day6_test_RatingController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/RatingController.java").isFile());
    }

	@Test
	@Order(26)
    void Day6_test_UserController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/UserController.java").isFile());
    }


	@Test
	@Order(27)
    void Day6_test_CategoryController_Has_RestController_Annotation() {
        try {
            // Load CategoryController class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");

            // Load @RestController annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");



            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @RestController annotation is missing on CategoryController class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RestController annotation on CategoryController.");
        }
    }

	
@Test
@Order(28)
void Day6_test_ProductController_Has_RestController_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.ProductController");
        Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @RestController annotation is missing on ProductController class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ ProductController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RestController annotation on ProductController.");
    }
}










@Test
@Order(29)

void Day6_test_CategoryController_Has_PostMapping() {
    try {
        // Load the controller class
        Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");

        // Load @PostMapping annotation dynamically
        Class<?> postMapping = Class.forName("org.springframework.web.bind.annotation.PostMapping");

        boolean found = false;

        // Check if any method has @PostMapping
        for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) postMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No method with @PostMapping found in CategoryController");

    } catch (ClassNotFoundException e) {
        fail("❌ CategoryController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PostMapping annotation in CategoryController.");
    }
}


@Test
@Order(30)

    void Day6_test_CategoryController_Has_GetMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");
            Class<?> getMapping = Class.forName("org.springframework.web.bind.annotation.GetMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) getMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @GetMapping method found in CategoryController");

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @GetMapping in CategoryController.");
        }
    }


	@Test
	@Order(31)

    void Day6_test_CategoryController_Has_PutMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");
            Class<?> putMapping = Class.forName("org.springframework.web.bind.annotation.PutMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) putMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @PutMapping method found in CategoryController");

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PutMapping in CategoryController.");
        }
    }

	@Test
	@Order(32)

    void Day6_test_CategoryController_Has_DeleteMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");
            Class<?> deleteMapping = Class.forName("org.springframework.web.bind.annotation.DeleteMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) deleteMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @DeleteMapping method found in CategoryController");

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @DeleteMapping in CategoryController.");
        }
    }




@Test
@Order(33)
public void Day6_testCreateCategory_NoBody_StatusBadRequest() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
}


@Test
@Order(34)
public void Day6_testGetAllCategories_StatusNoContent() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/categories"))
            .andExpect(MockMvcResultMatchers.status().isNoContent());
}

@Test
@Order(35)
public void Day6_testCreateCategory_EmptyName_StatusBadRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"categoryName\":\"\"}"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
}

	@Test
	@Order(36)
    void Day7_test_CategoryController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on CategoryController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in CategoryController.");
        }
    }


	@Test
	@Order(37)

    void Day7_test_CategoryController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable annotation found in any method parameter of CategoryController");

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in CategoryController.");
        }
    }


	@Test
	@Order(38)
    void Day7_test_ProductController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.ProductController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on ProductController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ ProductController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in ProductController.");
        }
    }


    @Test
	@Order(39)
    void Day7_test_UserController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on UserController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in UserController.");
        }
    }



	@Test
	@Order(40)
    void Day7_test_ProductController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.ProductController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of ProductController");

        } catch (ClassNotFoundException e) {
            fail("❌ ProductController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in ProductController.");
        }
    }


    @Test
	@Order(41)
    void Day7_test_UserController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in UserController.");
        }
    }


    @Test
	@Order(42)
    void Day7_test_RatingController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.RatingController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on RatingController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ RatingController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in RatingController.");
        }
    }







	@Test
	@Order(43)
    void Day8_test_CategoryService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/CategoryService.java").isFile());
    }

@Test
@Order(44)

void Day8_test_ProductService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/ProductService.java").isFile());
}

@Test
@Order(45)

void Day8_test_FeedbackService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/FeedbackService.java").isFile());
}

@Test
@Order(46)

void Day8_test_RatingService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/RatingService.java").isFile());
}


@Test
@Order(47)

void Day8_test_UserService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/UserService.java").isFile());
}


@Test
@Order(48)
void Day8_test_CategoryServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/CategoryServiceImpl.java").isFile());
}

@Test
@Order(49)

void Day8_test_ProductServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/ProductServiceImpl.java").isFile());
}

@Test
@Order(50)

void Day8_test_FeedbackServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/FeedbackServiceImpl.java").isFile());
}

@Test
@Order(51)

void Day8_test_RatingServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/RatingServiceImpl.java").isFile());
}

@Test
@Order(52)

void Day8_test_UserServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/UserServiceImpl.java").isFile());
}


    // POST /api/categories
    @Test
	@Order(53)
    public void Day8_testAddCategory() throws Exception {
		String requestBody = "{ \"categoryName\": \"Electronics\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("Electronics"))
                .andReturn();
    }

    // GET /api/categories
    @Test
	@Order(54)
    public void Day8_testGetAllCategories() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].categoryName").value("Electronics"))

                .andReturn();
    }

    // GET /api/categories/{id}
    @Test
	@Order(55)
    public void Day8_testGetCategoryById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("Electronics"))

                .andReturn();
    }

    // PUT /api/categories/{id}
    @Test
	@Order(56)
    public void Day8_testUpdateCategory() throws Exception {
        String requestBody = "{\"categoryName\": \"Electricals\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/categories/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.categoryName").value("Electricals"))
                .andReturn();
    }


    @Test
    @Order(57)
    public void Day9_testPagination_PageNumberApplied() throws Exception {
    
        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
    
                // ✔ Check only pageNumber
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(0));
    }
    

@Test
@Order(58)
public void Day9_testPagination_PageSizeApplied() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/page/1/10")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // ✔ Check only pageSize
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(10));
}



@Test
@Order(59)
public void Day9_testPagination_SortingPresent() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // ✔ Check sorting object exists
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort").exists())

            // ✔ sorting.sorted should be boolean (true if sorted)
            .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort.sorted").isBoolean());
}


@Test
@Order(60)
public void Day9_testPagination_ContentArrayExists() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // content should be an array, even if empty
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
}


@Test
@Order(61)
public void Day9_testPagination_TotalElementsExists() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // totalElements should exist
            .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").exists());
}


@Test
@Order(62)
public void Day9_testPagination_TotalPagesExists() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/page/0/5")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())

            // totalPages should exist
            .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").exists());
}


    
	@Test
	@Order(63)
	public void Day10_testAddProduct() throws Exception {
		String requestBody = "{ \"productName\": \"Laptop\", \"price\": 50000, \"category\": { \"categoryId\": 1 } }";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("Laptop"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(50000))
				//.andExpect(MockMvcResultMatchers.jsonPath("$.category.categoryId").value(1))
				.andReturn();
	}
	

	// GET /api/products
@Test
@Order(64)
public void Day10_testGetAllProducts() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].productName").value("Laptop"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(50000))
            //.andExpect(MockMvcResultMatchers.jsonPath("$[0].category.categoryId").value(1))
            .andReturn();
}

// GET /api/products/{id}
@Test
@Order(65)
public void Day10_testGetProductById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/products/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("Laptop"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(50000))
            //.andExpect(MockMvcResultMatchers.jsonPath("$.category.categoryId").value(1))
            .andReturn();
}

// PUT /api/products/{id}
@Test
@Order(66)
public void Day10_testUpdateProduct() throws Exception {
    String requestBody = "{ \"productName\": \"Updated Laptop\", \"price\": 55000, \"category\": { \"categoryId\": 1 } }";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/products/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("Updated Laptop"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(55000))
            //.andExpect(MockMvcResultMatchers.jsonPath("$.category.categoryId").value(1))
            .andReturn();
}


@Test
@Order(67)
public void Day10_testAddUser() throws Exception {
	String requestBody = "{ \"username\": \"johndoe\", \"email\": \"john@example.com\", \"role\": \"CUSTOMER\" }";

	mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.username").value("johndoe"))
			.andExpect(jsonPath("$.email").value("john@example.com"))
			.andExpect(jsonPath("$.role").value("CUSTOMER"))
			.andReturn();
}

// GET ALL USERS
@Test
@Order(68)
public void Day10_testGetAllUsers() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
            .andExpect(jsonPath("$[0].username").value("johndoe"))
			.andReturn();
}

// GET USER BY ID
@Test
@Order(69)
public void Day10_testGetUserById() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/api/users/1")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1))
			.andReturn();
}

// UPDATE USER
@Test
@Order(70)
public void Day10_testUpdateUser() throws Exception {
	String requestBody = "{ \"username\": \"janedoe\", \"email\": \"jane@example.com\", \"role\": \"ADMIN\" }";

	mockMvc.perform(MockMvcRequestBuilders.put("/api/users/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.username").value("janedoe"))
			.andExpect(jsonPath("$.email").value("jane@example.com"))
			.andExpect(jsonPath("$.role").value("ADMIN"))
			.andReturn();
}



@Test
@Order(71)
public void Day11_testGetUsersByRole() throws Exception {
    // Test the JPQL query endpoint
    mockMvc.perform(MockMvcRequestBuilders.get("/api/users/role/ADMIN")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("janedoe"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value("ADMIN"))
            .andReturn();
}


@Test
@Order(72)
public void Day12_testGetProductsByCategoryName() throws Exception {
    // Test the JPQL query endpoint
    mockMvc.perform(MockMvcRequestBuilders.get("/api/products/category/Electricals")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].productName").value("Updated Laptop"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(55000))
            .andReturn();
}


@Test
@Order(73)
public void Day12_testGetUserByUsernameAndRole() throws Exception {

    // Test JPQL endpoint: username + role
    mockMvc.perform(MockMvcRequestBuilders.get("/api/users/username/janedoe/role/ADMIN")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("janedoe"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value("ADMIN"))
            .andReturn();
}

@Test
@Order(74)
public void Day12_testGetUsersByRole_NotFound() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/users/role/MANAGER")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNoContent())
            .andExpect(MockMvcResultMatchers.content().string("No users found with role: MANAGER"));
}



@Test
@Order(75)
public void Day12_testGetProductByName() throws Exception {

    // Test JPQL endpoint: get product by name
    mockMvc.perform(MockMvcRequestBuilders.get("/api/products/name/Updated Laptop")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].productName").value("Updated Laptop"))
            .andReturn();
}

@Test
@Order(76)
public void Day12_testGetProductByName_NotFound() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/products/name/UnknownProduct")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.content().string("No products found with name: UnknownProduct"));
}

@Test
@Order(77)
    void Day13_test_exception_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }

	
@Test
@Order(78)
void Day13_test_GlobalException_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
}


@Test
@Order(79)
    void Day14test_configuration_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

@Test
@Order(80)
public void Day15_testAOPLogFileExists() {

    assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
   
}

}