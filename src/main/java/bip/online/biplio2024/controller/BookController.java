package bip.online.biplio2024.controller;
import bip.online.biplio2024.entity.BookEntity;
import bip.online.biplio2024.response.BaseResponse;
import bip.online.biplio2024.response.DataResponse;
import bip.online.biplio2024.response.ListResponse;
import bip.online.biplio2024.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<BookEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<BookEntity>(true, "Список книг: ", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<BookEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Найдена следующая книга: ", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<BookEntity>> save(@RequestBody BookEntity book) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Книга сохранен: ", service.save(book)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity book) {
        service.update(book);
        return ResponseEntity.ok(
                new BaseResponse(true, "Книга сохранен: "));
    }
}
