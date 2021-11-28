package ru.misha.carCurs.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.misha.carCurs.Entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
