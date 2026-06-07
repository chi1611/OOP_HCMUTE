package assignment07;

public interface LateFeePolicy {
    double applyPolicy(double baseFee);
    String getPolicyName();
}
