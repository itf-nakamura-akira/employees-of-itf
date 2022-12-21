package jp.co.itfllc.employeesofitf.controllers.masters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ユーザーマスター画面 Controller
 */
@RestController
@RequestMapping("/masters/users")
public class UsersController {
    /**
     * コンストラクター
     */
    public UsersController() {
    }

    /**
     * ユーザーリスト取得API
     *
     * @return ユーザーリスト
     */
    @GetMapping("/list")
    public GetListResponse GetList() {
        return new GetListResponse();
    }

    /**
     * GetListメソッドのレスポンス
     */
    public record GetListResponse() {
    }
}
