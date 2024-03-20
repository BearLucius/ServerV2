package bip.online.biplio2023.controller;



import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;

import bip.online.biplio2023.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="Книги", description="Содержит методы для работы с книгами")
@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BookController {
    private final BookService service;
    @Operation(
            summary = "Вывод Всех книг",
            description = "Позволяет вывести все книги, что есть в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<BookEntity>(true, "Список книг", service.findAll()));
    }
    @Operation(
            summary = "Поиск книги по id",
            description = "Позволяет искать книгу по его id"
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Найден следующий нига",
                        service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
///
    @GetMapping("/get")
    public  ResponseEntity<BaseResponse> getBookname(@RequestParam String bookName){
        return ResponseEntity.ok(new ListResponse(service.getBookName(bookName)));
    }
    @Operation(
            summary = "Добавить книгу",
            description = "Позволяет добавлять книгу в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody BookEntity books) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<BookEntity>(true, "Книга сохранена", service.save(books)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    } @Operation(
            summary = "Изменить книгу",
            description = "Позволяет редактировать и изменять книгу"
    )
        @PutMapping
        public ResponseEntity<BaseResponse> update (@RequestBody BookEntity books){
            try {
        service.update(books);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Книга сохранен"));
        } catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}@Operation(
            summary = "Удалить  книгу",
            description = "Позволяет удалить книгу из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Книга удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}
