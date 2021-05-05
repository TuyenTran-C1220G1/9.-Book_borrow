package repository;

import model.BorrowOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBorrowOrderRepository extends PagingAndSortingRepository<BorrowOrder,Long> {
}
