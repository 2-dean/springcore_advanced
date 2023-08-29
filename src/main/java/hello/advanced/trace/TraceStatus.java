package hello.advanced.trace;

public class TraceStatus {
    // 로그 상태정보 저장
    // 로그 시작 transactionID, message
    // 로그 종료시 transactionID, message , 로그 종료시간
    private TraceId traceId;
    private Long startTimeMs; //
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }


}
