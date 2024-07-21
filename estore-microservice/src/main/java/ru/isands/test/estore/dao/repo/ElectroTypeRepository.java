package ru.isands.test.estore.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.test.estore.dao.entity.ElectronicType;

public interface ElectroTypeRepository extends JpaRepository<ElectronicType, Long> {
}
