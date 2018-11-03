import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("loan_granted")
    input {
        triggeredBy("sendAccepted()")
    }
    outputMessage {
        sentTo("channel")
        body(
                loanNo: anyUuid(),
                loanLimit: anyNumber(),
                clientPesel: "85101406621",
                timestamp: anyIso8601WithOffset()
        )
        headers {
            header("type", "loan-granted")
            messagingContentType(applicationJson())
        }
    }
}
