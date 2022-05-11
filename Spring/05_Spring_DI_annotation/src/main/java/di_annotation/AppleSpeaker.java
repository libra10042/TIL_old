package di_annotation;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("-->> AppleSpeacker() 생성");
	}
	public void volumnUp() {
		System.out.println(">> AppleSpeacker - 소리크게");
	}
	public void volumnDown() {
		System.out.println(">> AppleSpeacker - 소리작게");
	}
}
