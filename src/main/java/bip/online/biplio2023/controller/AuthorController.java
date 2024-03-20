package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;
import bip.online.biplio2023.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Автор", description="Содержит методы для работы с авторами")
@RestController
@RequestMapping("api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;
    @Operation(
            summary = "Вывод всех авторов",
            description = "Позволяет получить имена всех авторов в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AuthorEntity>(true, "Список акторов", service.findAll()));
    }
    @Operation(
            summary = "Поиск по id",
            description = "Позволяет найти  авторов по их id  в бвзе"
    )
    @GetMapping("/byId")
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AuthorEntity>(true, "Найден следующий автор",
                            service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Добавить автора",
            description = "Позволяет добавить  автора в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody AuthorEntity author) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AuthorEntity>(true, "Автор сохранен", service.save(author)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "изменить автора",
            description = "Позволяет данные об  авторе в базе"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        try {
            service.update(author);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор сохранен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Удалить автора",
            description = "Позволяет удалить данные об  авторе из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}