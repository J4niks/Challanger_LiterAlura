package br.com.janiks.liter_alura.services;

public interface IDataConverter{
    <T> T getData(String json, Class<T> classe);
}
