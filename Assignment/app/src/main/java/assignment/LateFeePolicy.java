package assignment;

public interface LateFeePolicy {
    double applyPolicy(double baseFee);
    String getPolicyName();
}
