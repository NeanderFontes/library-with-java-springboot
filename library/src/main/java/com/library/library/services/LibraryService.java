package com.library.library.services;

import com.library.library.DTO.LibraryDTO;
import com.library.library.mapper.DozerMapper;
import com.library.library.model.LibraryModel;
import com.library.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository repository;

    public LibraryDTO findById(Long findItemById) {
        LibraryModel entityModel = repository.findById(findItemById).orElseThrow();
        return DozerMapper.parseObject(entityModel, LibraryDTO.class);
    }

    public List<LibraryDTO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), LibraryDTO.class);
    }

    public LibraryDTO create(LibraryDTO addEntityBook) {
        LibraryModel entityModel = DozerMapper.parseObject(addEntityBook, LibraryModel.class);
        LibraryDTO auxEntityDTO = DozerMapper.parseObject(repository.save(entityModel), LibraryDTO.class);
        return auxEntityDTO;
    }

    public LibraryDTO update(LibraryDTO updateEntityBook) {
        LibraryModel entityUpdateLibraryModel = repository.findById(updateEntityBook.getId()).orElseThrow();

        entityUpdateLibraryModel.setISBN(updateEntityBook.getISBN());
        entityUpdateLibraryModel.setName(updateEntityBook.getName());
        entityUpdateLibraryModel.setAuthor(updateEntityBook.getAuthor());

        LibraryDTO entityDTO = DozerMapper.parseObject(entityUpdateLibraryModel, LibraryDTO.class);
        repository.save(entityUpdateLibraryModel);
        return entityDTO;
    }

    public void delete(Long deleteEntityBook) {
        LibraryModel entityLibraryModel = repository.findById(deleteEntityBook).orElseThrow();
        repository.delete(entityLibraryModel);
    }
}
