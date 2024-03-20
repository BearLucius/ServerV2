package bip.online.biplio2023.controller;


import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;




import bip.online.biplio2023.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Публишер", description="Содержит методы для работы с издателем")
@RestController
@RequestMapping("api/v1/publisher")
@AllArgsConstructor
public class PublisherController {
    private final PublisherService service;
    @Operation(
            summary = "Вывод всех издателей",
            description = "Позволяет получить  всех издателей в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<PublisherEntity>(true, "Список Издательств", service.findAll()));
    }
    @Operation(
            summary = "поиск изадтеля по id",
            description = "Позволяет получить издателя по его id"
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Найден следующий издатель", service.findById(id).orElseThrow()));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
    @Operation(
            summary = "добавить издателя",
            description = "Позволяет добавить нового издателя в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody PublisherEntity publisher) {
        try{
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Издатель сохранен", service.save(publisher)));
    }catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));

    }
}
    @Operation(
            summary = "Изменить издателя",
            description = "Позволяет вносить изменения в издателя"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity publisher) {
       try{
        service.update(publisher);
        return ResponseEntity.ok(
                new BaseResponse(true, "Издатель сохранен"));
    }catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));

    }
}
    @Operation(
            summary = "Удалить издателя",
            description = "Позволяет удалить издателя из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Издатель удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}