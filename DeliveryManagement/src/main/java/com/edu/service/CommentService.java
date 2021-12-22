package com.edu.service;

import com.edu.pojo.Comment;
import com.edu.pojo.Customer;

public interface CommentService {
    Comment addComment(String content, int shipperId, Customer creator);
}
