package com.jxc.utils.realTimeMessage.controller;

import com.jxc.utils.realTimeMessage.NoticeWebsocket;
import com.jxc.utils.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	@GetMapping("/test")
    public R test() {
    	NoticeWebsocket.sendMessage("你好，WebSocket");
        return R.ok();
    }
}

