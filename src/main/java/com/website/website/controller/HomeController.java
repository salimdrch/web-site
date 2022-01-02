package com.website.website.controller;

import com.website.website.model.Product;
import com.website.website.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
// gestion des interactions entre l'utilisateur de l'application et l'application
//receptionner la requête et fournir la réponse
@Controller
public class HomeController {


    private final ProductService productService;

    // injecter une instance ProductService me permettant d'appeler les methodes pour communiquer avec la bd
    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String home(Model model){
        List<Product> productList = productService.getProductList();
        model.addAttribute("products", productList);
        return "home";
    }

    @GetMapping("/productList/{productCategory}")
    public String getProductByCategory(@PathVariable String productCategory, Model model){
        List<Product> productList = productService.getProductByCategory(productCategory);
        model.addAttribute("products", productList);
        model.addAttribute("productCategory", productCategory );
        return "productList";
    }

    @GetMapping("/viewProduct/{id}")
    public String getProductById(@PathVariable int id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewProduct";
    }

    @GetMapping("/productList/remove/{id}")
    public String deleteProductById(@PathVariable int id, Model model, RedirectAttributes redirectAttributes){
        Product product = productService.getProductById(id);

        try {
            productService.deleteProductById(id);
        } catch (IllegalStateException e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/productList/" + product.getProductCategory() ;
    }

    // show form
    @GetMapping("/productList/add-form")
    public  String showNewForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Add your sneak");
        return "/add-form";
    }

    //add product in data base
    @PostMapping("/productList/save")
    public String addProduct(Product product){
        System.out.println(" IMAGE ---> "+product.getProductImage());
        productService.saveProduct(product);
        return "redirect:/productList/"+ product.getProductCategory();
    }

    @GetMapping("/viewProduct/edit/{id}")
    public String updateProduct(@PathVariable int id,Model model,RedirectAttributes redirectAttributes ){
        try {
            Product product = productService.getProductById(id);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "Edit your sneak Id -> " + id);
            productService.deleteProductById(id);
            return "add-form";
        } catch (IllegalStateException e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/";

        }
    }





    // requete http de type GET retournera le code de cette mehode
    // appele la methode getProductList() -> qui app findAlll() -> obtient tous les produits
    @GetMapping
    public List<Product> getProductList(){
        return productService.getProductList();
    }


}
