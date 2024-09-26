package org.uststore.appleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uststore.appleservice.model.Apple;
import org.uststore.appleservice.repository.AppleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppleServiceImpl implements AppleService {

    @Autowired
    private AppleRepository appleRepository;

    @Override
    public List<Apple> getApples() {
        return appleRepository.findAll();
    }

    @Override
    public Optional<Apple> getApple(long id) {
        return appleRepository.findById(id);
    }

    @Override
    public Apple addApple(Apple apple) {
        return appleRepository.save(apple);
    }

    @Override
    public Apple updateApple(Apple apple) {
        if(appleRepository.findById(apple.getId()).isPresent()) {
            return appleRepository.save(apple);
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteApple(long id) {
        if(appleRepository.findById(id).isPresent()) {
            appleRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
