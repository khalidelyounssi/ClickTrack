package ma.youcode.clicktrack.dto;

public record OffreResponse(
        String offre,
        long nombreLiens,
        long clicks
) {
}