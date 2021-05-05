package service.impl;

import model.BorrowOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBorrowOrderRepository;
import service.IBorrowOrderService;

import java.util.List;
import java.util.Optional;
@Service
public class BorrowOrderService implements IBorrowOrderService {
    @Autowired
    IBorrowOrderRepository borrowOrderRepository;

    @Override
    public List<BorrowOrder> findAll() {
        return (List<BorrowOrder>) borrowOrderRepository.findAll();
    }

    @Override
    public Optional<BorrowOrder> findById(Long id) {
        return borrowOrderRepository.findById(id);
    }

    @Override
    public void save(BorrowOrder borrowOrder) {
        borrowOrderRepository.save(borrowOrder);
    }
}
