package org.uststore.appleservice.service;

import org.uststore.appleservice.model.Apple;
import java.util.List;
import java.util.Optional;

public interface AppleService {
    public List<Apple> getApples();
    public Optional<Apple> getApple(long id);
    public Apple addApple(Apple apple);
    public Apple updateApple(Apple apple);
    public boolean deleteApple(long id);

}
