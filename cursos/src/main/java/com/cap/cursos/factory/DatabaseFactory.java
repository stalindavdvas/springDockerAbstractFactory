package com.cap.cursos.factory;

public interface DatabaseFactory {
    Object createRepository(String type);
}