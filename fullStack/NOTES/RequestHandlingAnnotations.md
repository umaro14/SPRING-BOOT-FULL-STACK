# Request Handling and Controller annotations:
Some important annotations comes under this category are:

# @Controller
# @RestController
# @RequestMapping
# @RequestParam
# @PathVariable
# @RequestBody
# @ResponseBody
# @ModelAttribute

# -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-

# 1. @Controller Annotation
This annotation provides Spring MVC features.
It is used to create Controller classes and simultaneously it handles the HTTP requests.
Generally we use @Controller annotation with @RequestMapping annotation to map HTTP requests with methods inside a controller class.
     
#   @Controller
    public class MyController{
    public String GFG(){
        //insert code here
        }
#    }

# 2. @RestController Annotation
This annotation is used to handle REST APIs. and also used to create RESTful web services using Spring MVC.
It encapsulates @Controller annotation and @ResponseBody annotation with their default attributes.
# @RestController = @Controller + @ResponseBody 

# @RestController
public class HelloController{
  public String GFG(){
    //insert code here
  }
# }

3. @RequestMapping Annotation
Maps HTTP requests to handler methods.
Supports GET, POST, PUT, DELETE, etc.
Example:


# @RestController
public class Geeks{
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to Spring Boot!";
    }
# }

# For handling specific HTTP requests we can use

@GetMapping
@PutMapping
@PostMapping
@PatchMapping
@DeleteMapping

# NOTE: We can manually use GET, POST, PUT and DELETE annotations along with the path as well as we can use @RequestMapping annotation along with the method for all the above handler requests 