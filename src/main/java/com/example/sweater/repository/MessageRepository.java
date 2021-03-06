package com.example.sweater.repository;

import com.example.sweater.model.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
}
