package com.edu.controller;

import com.edu.pojo.Comment;
import com.edu.pojo.Customer;
import com.edu.pojo.User;
import com.edu.service.CommentService;
import com.edu.service.CustomerService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping(path = "/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params,
            HttpSession session) {
        
        User user = (User) session.getAttribute("currentUser");
//        Customer creator = this.customerService.getCustomerById(2);
        Customer creator = this.customerService.getCustomerById(user.getId());
        if (creator != null) {
            try {
                String content = params.get("content");
                int shipperId = Integer.parseInt(params.get("shipperId"));
                Comment comment = this.commentService.addComment(content, shipperId, creator);
                
                return new ResponseEntity<>(comment, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
