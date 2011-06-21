package kz.edu.sdu.apps.uni.client.dto;

public enum ClassEnrollStatus {

	REJECTED(-1),ENROLLED(0),WAITING(1),DROPPED(2),DELETED(3);
	
	private final int ord;
	ClassEnrollStatus(int v) {
		ord=v;
	}
	
}
