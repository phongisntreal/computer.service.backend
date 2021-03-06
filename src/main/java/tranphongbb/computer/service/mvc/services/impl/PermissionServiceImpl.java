package tranphongbb.computer.service.mvc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tranphongbb.computer.service.mvc.entity.Permission;
import tranphongbb.computer.service.mvc.repositories.PermissionRepository;
import tranphongbb.computer.service.mvc.services.PermissionService;

import java.util.List;

/*
 * Made by Pt. Copyright (c) 3/2020.
 */

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    @Override
    public List<Permission> findAll() {
        return repo.findAll();
    }

    @Override
    public Permission findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Permission> saveAll(List<Permission> list) {
        return repo.saveAll(list);
    }

    @Override
    public Permission save(Permission object) {
        return repo.saveAndFlush(object);
    }

    @Override
    public Permission delete(Permission object) {
        if (object != null) {
            object.setDeleted(true);
            return repo.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Permission deleteById(int id) {
        Permission byId = findById(id);
        if (byId != null) {
            byId.setDeleted(true);
            return repo.save(byId);
        } else {
            return null;
        }
    }
}
