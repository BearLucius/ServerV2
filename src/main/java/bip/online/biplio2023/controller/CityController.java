package bip.online.biplio2023.controller;



import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;


import bip.online.biplio2023.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Город", description="Содержит методы для работы с городом")
@RestController
@RequestMapping("api/v1/city")
@AllArgsConstructor
public class CityController {
    private final CityService service;

    @Operation(
            summary = "Вывод всех городов.",
            description = "Позволяет выводить все города, что есть в БД."
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {

        return ResponseEntity.ok(
                new ListResponse<CityEntity>(true, "Список городов: ", service.findAll()));
    }
    @Operation(
            summary = "Поиск города по id.",
            description = "Позволяет искать город по его Id."
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Найден следующий город: ", service.findById(id).orElseThrow()));
    } catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}
    @Operation(
            summary = "Добавить город.",
            description = "Позволяет добовить новый город в БД."
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody CityEntity city) {
        try {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Город сохранен: ", service.save(city)));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить город.",
            description = "Позволяет редактировать и изменять город."
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
        try {
        service.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город сохранен."));
    }catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}
    @Operation(
            summary = "Удалить город.",
            description = "Позволяет удалить город из базы."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Город удален."));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}