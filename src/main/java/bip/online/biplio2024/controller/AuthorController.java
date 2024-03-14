package bip.online.biplio2024.controller; import bip.online.biplio2024.entity.AuthorEntity;

import bip.online.biplio2024.response.BaseResponse;
import bip.online.biplio2024.response.DataResponse;
import bip.online.biplio2024.response.ListResponse;
import bip.online.biplio2024.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<AuthorEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AuthorEntity>(true, "Список авторов: ", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<AuthorEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Найден следующий автор: ", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<AuthorEntity>> save(@RequestBody AuthorEntity author) {
        return ResponseEntity.ok(
                new DataResponse<AuthorEntity>(true, "Автор сохранен: ", service.save(author)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        service.update(author);
        return ResponseEntity.ok(
                new BaseResponse(true, "Автор сохранен: "));
    }
}