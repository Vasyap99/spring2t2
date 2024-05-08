package kok.spring21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Controller1 {
    @GetMapping("/pip")
    public String fun(){
        System.out.println("111");
        return "111";
    }
    @GetMapping("/calc")
    public String calc(@RequestParam(value="par1")String par1,@RequestParam(value="par2")String par2,@RequestParam(value="op")char op, Model model){
		double p1=Double.parseDouble(par1);
		double p2=Double.parseDouble(par2);
        double r;
		switch(op){
			case 'a':
				r=p1+p2;
				break;
			case 's':
				r=p1-p2;
				break;
			case 'm':
				r=p1*p2;
				break;
			case 'd':
				r=p1/(double)p2;
				break;
			default:
				r=0;
		}
		model.addAttribute("result",r);
        return "calcres";
    }
}
