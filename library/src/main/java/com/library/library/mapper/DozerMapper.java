package com.library.library.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <LibraryModel, LibraryDTO> LibraryDTO parseObject(LibraryModel origin, Class<LibraryDTO> destination) {
        return mapper.map(origin, destination);
    }

    public static <LibraryModel, LibraryDTO> List<LibraryDTO> parseListObject(List<LibraryModel> origin, Class<LibraryDTO> libraryDTOClass) {
        List<LibraryDTO> destinationObject = new ArrayList<>();
        for (LibraryModel objectModel : origin) {
            destinationObject.add(mapper.map(objectModel, libraryDTOClass));
        }
        return destinationObject;
    }
}
