package com.briup.bookstore.exception;

public class BookStoreException extends RuntimeException {
    /*
     * 状态码
     */
    private int code;

    /*
     * 提示信息
     */
    private String msg;

    /*
     * 获取状态码
     */
    public int getCode() {
        return code;
    }

    /*
     * 获取提示信息
     */
    public String getMsg() {
        return msg;
    }

    /*
     * 构造器，将枚举状态码和提示信息作为参数传入
     */
    public BookStoreException(CodeMsgEnum codeMsgEnum) {
        super(codeMsgEnum.getMsg());
        this.code = codeMsgEnum.getCode();
        this.msg = codeMsgEnum.getMsg();
    }

    /*
     * 构造器 ，将状态码和提示信息作为参数传入
     */
    public BookStoreException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public enum CodeMsgEnum {
        //响应失败
        ERROR(500, "服务器内部错误"),

        //用户名不能为空
        USER_USERNAME_IS_NOT_NULL(501, "用户名不能为空"),

        //密码不能为空
        USER_PASSWORD_IS_NOT_NULL(502, "密码不能为空"),

        //用户名或密码错误
        USER_USERNAME_OR_PASSWORD_ERROR(503, "用户名或密码错误"),

        //用户未登录
        USER_IS_NOT_LOGIN(504, "用户未登录"),

        //登录过期
        USER_LOGIN_TIMEOUT(505, "用户身份登录过期"),

        //令牌失效
        USER_TOKEN_IS_INVALID(506, "无效token"),

        //用户ID不能为空
        USER_ID_IS_NOT_NULL(507, "用户ID不能为空"),

        //用户对象不存在
        USER_IS_NOT_EXIST(508, "管理员对象不存在"),

        //用户用户名已存在
        USER_USERNAME_IS_EXIST(509, "用户名已经被占用，请更换重试"),

        //待删除用户ID集合不能为空
        TO_BE_DELETE_USER_IDS_IS_NOT_NULL(510, "待删除管理员ID集合不能为空"),

        //文件格式错误
        FILE_TYPE_ERROR(511, "图片类型错误，只能是 .jpg 或 .png格式 "),


        //登录账号与登录系统不符
        LOGIN_IDENTITY_IS_INVALID(512, "账号权限不足，请联系管理员"),

        //删除用户失败，待删除用户存在购物车信息、订单信息、收货地址信息，请检查删除完毕后重试
        DELETE_USER_FAIL(513, "删除用户失败，待删除用户存在购物车信息、订单信息、收货地址信息，请检查删除完毕后重试"),

        //账号已被封禁，请联系管理员
        USER_STATUS_CLOSE(514, "账号已被封禁，请联系管理员"),
        //新旧密码不能相同
        SAME_OLD_PASSWORD(515, "不能与原密码相同"),
        //密码错误
        PASSWORD_ERROR(516, "密码错误,验证不通过"),

        //分类名称已经存在
        CATEGORY_NAME_IS_EXIST(601, "分类名称已经存在！"),

        //指定的分类信息不存在
        CATEGORY_IS_NOT_EXIST(602, "指定的分类信息不存在"),

        //待删除分类ID集合不能为空
        TO_BE_DELETE_CATEGORY_IDS_IS_NOT_NULL(603, "待删除分类ID集合不能为空"),

        //删除分类信息失败，待删除分类有关联的图书信息、父分类下有子分类未被删除，请检查删除完毕后重试
        DELETE_CATEGORY_FAIL(604, "删除分类信息失败，待删除分类有关联的图书信息、父分类下有子分类未被删除，请检查删除完毕后重试"),

        BOOK_NOT_EXIST(701, "图书信息不存在，请刷新页面重试"),

        BOOK_NAME_IS_NULL(702, "图书名称为空"),

        BOOK_AUTHOR_IS_NULL(703, "图书作者为空"),

        BOOK_PUBLISHER_IS_NULL(704, "图书出版社为空"),

        CATEGORY_NOT_EXIST(705, "分类信息不存在，图书添加失败"),

        TO_BE_DELETE_LOG_IDS_IS_NOT_NULL(706, "待删除的日志集合不能为空"),
        ORDER_CAN_NOT_CLOSE(801, "该订单不能被关闭"),

        DISTRIBUTION_MODE_IS_NULL(802, "快递单号不能为空"),
        TRACKING_NUMBER_IS_NULL(803, "配送方式不能为空"),
        ORDER_CAN_NOT_DELIVERY(804, "该订单不能发货"),
        ORDER_CAN_NOT_COMPLETE(805,"该订单不能确认收货"),
        ADDRESS_CAN_NOT_NULL(901,"收货信息不能为空")
        ;


        //响应状态码
        int code;
        //响应信息
        String msg;

        //全参构造器
        CodeMsgEnum(int code, String errorMessage) {
            this.code = code;
            this.msg = errorMessage;
        }

        //获取响应状态码
        public int getCode() {
            return code;
        }

        //获取响应信息
        public String getMsg() {
            return msg;
        }
    }

}
