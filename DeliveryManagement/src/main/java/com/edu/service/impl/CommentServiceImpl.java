package com.edu.service.impl;

import com.edu.pojo.Comment;
import com.edu.pojo.Customer;
import com.edu.pojo.Shipper;
import com.edu.repository.CommentRepository;
import com.edu.repository.CustomerRepository;
import com.edu.repository.ShipperRepository;
import com.edu.service.CommentService;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private ShipperRepository shipperRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public Comment addComment(String content, int shipperId, Customer creator) {
        Shipper shipper = this.shipperRepository.getShipperById(shipperId);
        Comment comment = new Comment();
        
        comment.setContent(content);
        comment.setCustomerId(creator);
        comment.setShipperId(shipper);
        comment.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(comment);
    }
    
}
