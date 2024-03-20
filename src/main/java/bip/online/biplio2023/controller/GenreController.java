package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;
import bip.online.biplio2023.service.AuthorService;
import bip.online.biplio2023.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Жанр", description="Содержит методы для работы с Жанром")
@RestController
@RequestMapping("api/v1/genre")
@AllArgsConstructor
public class GenreController {
    private final GenreService service;
    @Operation(
            summary = "Вывод всех  жанров",
            description = "Позволяет вывести все жанры, которые есть в бахе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<GenreEntity>(true, "Список Жанров", service.findAll()));
    }
    @Operation(
            summary = "поиск жанра по id",
            description = "Позволяет жанр"
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Найден следующий Жанр", service.findById(id).orElseThrow()));
    }
    @Operation(
            summary = "добавить жанр",
            description = "Позволяет добавлять новый жанр"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody GenreEntity genre) {
        try {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Жанр сохранен", service.save(genre)));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить жанр",
            description = "Позволяет редактировать и изменять жанр"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody GenreEntity genre) {
        try {
        service.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен"));
    }  catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
        }
    @Operation(
            summary = "Удалить жанр",
            description = "Позволяет удалять жанр из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Жанр удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}

