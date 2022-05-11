package di_annotation;

import org.springframework.stereotype.Component;

//@Component("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("-->> SonySpeacker() 생성");
	}
	public void volumnUp() {
		System.out.println(">> SonySpeacker - 소리크게");
	}
	public void volumnDown() {
		System.out.println(">> SonySpeacker - 소리작게");
	}
}
