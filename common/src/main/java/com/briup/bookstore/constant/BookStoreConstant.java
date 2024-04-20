package com.briup.bookstore.constant;

public class BookStoreConstant {

    /*
     * 服务网关  ---  沙箱环境
     */

    public static final String SERVER_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    /*
     * 应用id,
     */

    public static final String APP_ID = "9021000132690065";

    /*
     * 用户私钥,可以替换成你们的自己的私钥
     *
     */

//    public static final String APP_PRIVATE_KEY = "";
    public static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCP/M4NSkB0bUyw0inNhKU16J6NmLOfnZScu6Ooh7sk0L1DEqD6YdRyMLtoxpn5rGB0CG4Jgjhpahe99VXGitosLalbOPR4t538OY6e5bhgNDSbnWcErk+B4o3NmZQ1eEQj9spSc/l08X11pNK/mbqOCResFGMIyQ4Pnp4Qb2ggNpHwk9VvdFDFCgVeBqDqG78mPTuB05vE1xObtH+f6Bl6fOWYTJMgQiAF7vJMYNz1PSeczDj0kFiMjtWD5kM+q/8h9bZb+bG0nGC5wDaEzAOBZiZi/wirlrwARFkIZanv3g2xuHa2I7eLfAaxRMQ+8Sz65px1qapct/hG8bgEdZutAgMBAAECggEACO90TgjUlSUPRE3WgEWCByVnaXwXcYlS5qMSVewOZgt6I0ZtrPwTNf7mMmtYtNDIr4qyYW6uV4RY8tXdu9N0FJfE0b9oFHG4oSVlP2EcHwQ+W4XaFcVHc9T+XcrxEpxjBiRTi+hci7BMy9ctqOw+UoAn8urU9n+bmsaKIpT3TkBcU8jMNGiQFKGGFZg6hX4A5bTO9+idBtDgNrjZgLhjRS8gRt3qg8Qyelac38aJjp8lasO5mtBVqayz7TJ0zNsgDov3gREVqzadJnPXgQUahq7jifkKGOdUH/eBe53CPN5+cb1I0N11ot05Py/3Oo723pFmza6TiikRzJ1wx9729QKBgQDtD47y84a7mHyhF14sPilt6yBYxSMQK+Ef1RdUXkNMY6+gishBXDt34tvz4qSg9Dfq8/Ms+ftPhD+/PdE28QMAYjJUwF0fspGMmi76YnkxvlwjbOJcud6e58fAdc2aAMGmuoVHFLIlISfBxYBRuht9KijibyHSP2tMoxUDc/GjpwKBgQCbfa7Ws0Wc53Z/Vc7ogl6PMA2MJEL2AvemYMONOhjfnz46all+CVjpUKQiFCqOpEHZ50fvDYhaa61XfeQTld0OgZJHzEtjGD6MC92nVthK8hip9wUQCAnAnCEbjgv0UwXI9ROto3DI+AdXt0HfMWtoVqwkNactXASZqFDw6OhAiwKBgQDWAEeRdtnYG83WNpwi4HLR8YIf4MbIYHQ4IkuPNBEYspznFqG0ryhYD4lz3tOzIQQhq9uIbJq7q61IXOuy51tIS10YORdX+AGApedmzOKPT0MqD69A+eHIHYCrcy0Jq0kl1BdglYREFGwpdrtiC9mo4hhKYPxtKicY5degaFho3QKBgEF3XEqnNjMGvTyFm1UHttpgqAOOLOc5fp19djga8ugMOv4LUtyfAOFTA5gZl4VxIQymtQGwV+2CEnyY05NvcKAv66/xEviI96StRkizZuO/JKVDDM2gJMMEuWfJmbzny7K9hOiBvPXQf/7teH2JaCiI/XdNY7LUYFd1p4aW+VpbAoGAOP38kAfYkbS4Qld1+HUAK9OMfufJz8H1EyvRffb3RicPpq34Yea8rPznPwBq3AFqW/42BUvCVLVJUexTmCIaURYTx6Ey1fFrSsdqPXec3s6e72LTS4i8zYSHEoSqvMVTXWOGWFoDg12ksFSpKYU54JQTMzJOShCgFtaXgs5Y4H0=";

    /*
     * 发送数据的格式,  目前为json
     *
     */

    public static final String FORMAT = "json";

    /*
     * 设置字符集的编码格式 utf-8
     */

    public static final  String CHARSET = "utf-8";

    /*
     * 支付宝公钥
     * public static final String ALIPAY_PUBLIC_KEY = "";
     */
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2SwbHiS+hA6+SF6HgjZaJoANHccRL5HnL+TcJXrr0APSu8OZsfz17EjT9sr8NWA5C6PPFzOuFEDNsnTldCz8R48g4Mr5o+jQiSdHZJX6/eqS/GXs+JsY9huZ4pKh49s1IjmFQKgZScr+YnW6AaD+dBgQu6UoZnpunaebQ6btwFkzj3MuLkelW59OaVS5Q6t3slFkYh6VUwez38F3LZJUVTJZCY6KiSPPCcOzBAV04hlm6ROhBwYVGP7isDJMxUV5nZFHPl9mCEF6G0RwFSTPRLmq0tpFx/SlrkEhdBg6gyG3xyQY28J/Pyg5zj1lenkNPjPk8t/e0WIzPPBGQtXHwQIDAQAB";

    /*
     * 支付宝签名  目前采用的是RSA2
     */

    public static final String SIGN_TYPE = "RSA2";

    /*
     * 账号状态为封禁状态
     */
    public static final int LOGIN_STATUS_CLOSE = 1;

    /**
     * 账号状态为启用状态
     */
    public static final int LOGIN_STATUS_OPEN = 0;

    /*
     * 前台登录角色ID
     */
    public static final Integer LOGIN_ADMIN = 1;


    /*
     * 前台登录角色ID
     */
    public static final Integer LOGIN_USER = 2;


    /**
     * 订单前缀
     */
    public  static  final  String ORDER_ID_PREFIX="briup";;


}
