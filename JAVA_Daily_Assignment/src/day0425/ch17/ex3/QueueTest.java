package day0425.ch17.ex3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
	
		Queue reqQueue = new LinkedList();
		
		//요청 추가
		reqQueue.add("로그인");
		reqQueue.add("렌터카 예약");
		reqQueue.add("렌터카 등록");
		System.out.println(reqQueue.size());
		
		//요청 접근 및 반환
		String request = (String)reqQueue.poll();
		System.out.println(request);
		System.out.println(reqQueue.poll());
		System.out.println(reqQueue.poll());
		System.out.println(reqQueue.size());
		System.out.println();

		//다시 요청 추가
		reqQueue.add("로그인");
		reqQueue.add("로그인");
		reqQueue.add("예약 조회");
		reqQueue.add("렌터카 예약");
		reqQueue.add("회원 가입");
		System.out.println(reqQueue.size());
		System.out.println(reqQueue.toString());
	}

}
