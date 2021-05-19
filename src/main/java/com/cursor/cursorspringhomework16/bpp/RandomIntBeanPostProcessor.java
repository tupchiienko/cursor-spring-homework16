package com.cursor.cursorspringhomework16.bpp;

import com.cursor.cursorspringhomework16.annotation.RandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class RandomIntBeanPostProcessor implements BeanPostProcessor {
    private final Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            RandomInt randomIntAnnotation = field.getAnnotation(RandomInt.class);
            if (randomIntAnnotation != null) {
                if (!field.getType().equals(int.class)) {
                    throw new RuntimeException("don't put @RandomInt above " + field.getType());
                }
                int min = randomIntAnnotation.min();
                int max = randomIntAnnotation.max();
                int randomInt = min + random.nextInt(max - min);
                try {
                    field.setAccessible(true);
                    field.set(bean, randomInt);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }
}
