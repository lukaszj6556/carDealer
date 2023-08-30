package com.retail.dbConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.retail.shop.car.model.Dealer;

import java.io.File;
import java.io.IOException;

public class MapperFactory {
    ObjectMapper mapper;
    public ObjectMapper get() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();

        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        ObjectMapper mapperObject = new ObjectMapper(new YAMLFactory());
        mapperObject.findAndRegisterModules();
        this.mapper = mapperObject;
    }

    public Dealer readValue(String DATABASE_YAML) {
        try {
            return mapper.readValue(ClassLoader.getSystemResourceAsStream(DATABASE_YAML), Dealer.class);
        } catch (IOException ex) {
            System.out.println(
                    "Problem with accessing files with data. Check if file database.yaml exists in folder resources."
                            + ex.getMessage());
        }

        return new Dealer();
    }

    public void writeValue(Dealer dealer, String path, String filename) throws IOException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(path, filename), dealer);
    }
}
