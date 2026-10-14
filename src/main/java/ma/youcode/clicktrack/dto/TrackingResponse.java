package ma.youcode.clicktrack.dto;

public record TrackingResponse(String urlRedirection,
        String publisher, String offre, long clicks) { }