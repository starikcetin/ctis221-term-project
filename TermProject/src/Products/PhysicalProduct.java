package Products;

public abstract class PhysicalProduct extends Product {
    
    @Override
    public MediumType getMediumType()
    {
        return MediumType.Physical;
    }
}
