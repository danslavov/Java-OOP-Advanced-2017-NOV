import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AssemblerTests {

    private Assembler assembler;
    private Part arsenalPart;
    private Part shellPart;
    private Part endurancePart;

    @Before
    public void init() {
        this.assembler = new VehicleAssembler();

        AttackModifyingPart amp = Mockito.mock(AttackModifyingPart.class);
        this.arsenalPart = amp;
        Mockito.when(amp.getWeight()).thenReturn(10.0);
        Mockito.when(amp.getPrice()).thenReturn(new BigDecimal("10"));
        Mockito.when(amp.getAttackModifier()).thenReturn(10);

        DefenseModifyingPart dmp = Mockito.mock(DefenseModifyingPart.class);
        this.shellPart = dmp;
        Mockito.when(dmp.getWeight()).thenReturn(10.0);
        Mockito.when(dmp.getPrice()).thenReturn(new BigDecimal("10"));
        Mockito.when(dmp.getDefenseModifier()).thenReturn(10);

        HitPointsModifyingPart hpmp = Mockito.mock(HitPointsModifyingPart.class);
        this.endurancePart = hpmp;
        Mockito.when(hpmp.getWeight()).thenReturn(10.0);
        Mockito.when(hpmp.getPrice()).thenReturn(new BigDecimal("10"));
        Mockito.when(hpmp.getHitPointsModifier()).thenReturn(10);

        this.assembler.addArsenalPart(amp);
        this.assembler.addShellPart(dmp);
        this.assembler.addEndurancePart(hpmp);
    }

    @Test
    public void getsCorrectTotalWeight() {
        double totalWeight = this.assembler.getTotalWeight();
        Assert.assertEquals(30, totalWeight, 0);
    }

    @Test
    public void getsCorrectPrice() {
        BigDecimal totalPrice = this.assembler.getTotalPrice();
        Assert.assertEquals(new BigDecimal("30"), totalPrice);
    }

    @Test
    public void getsCorrectAttack() {
        long totalAttack = this.assembler.getTotalAttackModification();
        Assert.assertEquals(10, totalAttack);
    }

    @Test
    public void getsCorrectDefense() {
        long totalDefense = this.assembler.getTotalDefenseModification();
        Assert.assertEquals(10, totalDefense);
    }

    @Test
    public void getsCorrectHitPoints() {
        long totalHitPoints = this.assembler.getTotalHitPointModification();
        Assert.assertEquals(10, totalHitPoints);
    }

    @Test
    public void testAddArsenalPart() throws NoSuchFieldException, IllegalAccessException {
        this.assembler.addArsenalPart(this.arsenalPart);

//        boolean equalIsFound = false;

        Class<?> assemblerClass = this.assembler.getClass();
        Field[] fields = assemblerClass.getDeclaredFields();
        List<Part> allParts = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            List<Part> parts = (List<Part>) field.get(this.assembler);
            Assert.assertFalse(parts.isEmpty());

            allParts.addAll(parts);
        }

        Assert.assertTrue(
                allParts.contains(this.arsenalPart) &&
        allParts.contains(this.endurancePart) && allParts.contains(this.shellPart));


    }

//    @Test
//    public void testAddShellPart() throws NoSuchFieldException, IllegalAccessException {
//        this.assembler.addShellPart(this.shellPart);
//
//        Class<?> assemblerClass = this.assembler.getClass();
//        Field field = assemblerClass.getDeclaredField("shellParts");
//        field.setAccessible(true);
//        List<DefenseModifyingPart> list = (List<DefenseModifyingPart>) field.get(this.assembler);
//        Part actualPart = list.get(0);
//
//        Assert.assertEquals(this.shellPart, actualPart);
//    }
//
//    @Test
//    public void testAddEndurancePart() throws NoSuchFieldException, IllegalAccessException {
//        this.assembler.addEndurancePart(this.endurancePart);
//
//        Class<?> assemblerClass = this.assembler.getClass();
//        Field field = assemblerClass.getDeclaredField("enduranceParts");
//        field.setAccessible(true);
//        List<HitPointsModifyingPart> list = (List<HitPointsModifyingPart>) field.get(this.assembler);
//        Part actualPart = list.get(0);
//
//        Assert.assertEquals(this.endurancePart, actualPart);
//    }




//    Field field = assemblerClass.getDeclaredField("arsenalParts");
//        field.setAccessible(true);
//        List<AttackModifyingPart> list = (List<AttackModifyingPart>) field.get(this.assembler);
//        Part actualPart = list.get(0);

//        Assert.assertEquals(this.arsenalPart, actualPart);



}
