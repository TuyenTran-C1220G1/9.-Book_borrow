package controller;

import exception.OutOfStockException;
import model.Book;
import model.BorrowOrder;
import model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IBookService;
import service.IBorrowOrderService;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("counter")
@RequestMapping("/order")
public class BorrowOrderController {
    @ModelAttribute("listBook")
    @Autowired
    List<Book> listBook() {
        return bookService.findAll();
    }

    @ModelAttribute("counter")
    public Counter setupCounter(){
        return new Counter();
    }

    @Autowired
    IBorrowOrderService borrowOrderService;

    @Autowired
    IBookService bookService;

    @GetMapping("")
    ModelAndView showAll(Counter counter) {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<BorrowOrder> borrowOrderList = borrowOrderService.findAll();
        modelAndView.addObject("listOrder", borrowOrderList);
        counter.increment();
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("order", new BorrowOrder());
        return modelAndView;
    }

    @PostMapping("/create")
    String create(@ModelAttribute BorrowOrder borrowOrder) throws OutOfStockException {
        Optional<Book> book = bookService.findById(borrowOrder.getBook().getId());
        if(book.get().getAmount()<=0){
            throw new OutOfStockException();
        }
        book.get().setAmount(book.get().getAmount()-1);
        bookService.save(book.get());
        borrowOrderService.save(borrowOrder);
        return "redirect:/order";
    }
    @ExceptionHandler(OutOfStockException.class)
    public String showOutOfStockError(){
        return "/error";
    }


}
