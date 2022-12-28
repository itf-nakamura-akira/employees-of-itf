package jp.co.itfllc.employeesofitf.enums;

/**
 * システム権限
 */
public enum SystemAuthority {
    /**
     * 管理者
     */
    Administrator("Administrator"),

    /**
     * マネージャー
     */
    Manager("Manager"),

    /**
     * 一般
     */
    General("General");

    /**
     * システム権限
     */
    private String authority;

    /**
     * コンストラクター
     *
     * @param authority システム権限
     */
    private SystemAuthority(String authority) {
        this.authority = authority;
    }
}
