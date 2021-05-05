package service;

import model.BorrowOrder;

import java.util.List;
import java.util.Optional;

public interface IBorrowOrderService {
    List<BorrowOrder> findAll();

    Optional<BorrowOrder> findById(Long id);

    void save(BorrowOrder borrowOrder);
}