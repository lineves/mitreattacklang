package core;

import java.util.Set;

public class AttackStepMin extends AttackStep {
   public AttackStepMin(String name) {
      super(name);
   }

   @Override
   public void updateTtc(AttackStep parent, double parentTtc, Set<AttackStep> activeAttackSteps) {
      expectedParents.remove(parent);
      visitedParents.add(parent);
      if (parentTtc + localTtc() < ttc) {
         ttc = parentTtc + localTtc();
         activeAttackSteps.add(this);
      }
      // System.out.println("Reached OR AttackStep" + this.fullName() + " at
      // time " + Double.toString(ttc) + " from " + parent.fullName() + "(" +
      // Double.toString(parent.ttc) + ").");
   }

}
