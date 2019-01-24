/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Spark l1;
  public Spark l2;
  public Spark r1;
  public Spark r2;

  public SpeedControllerGroup lMotor;
  public SpeedControllerGroup rMotor;

  public DifferentialDrive mdrive;

  public DriveSystem() {
    l1 = new Spark(RobotMap.L1_DRIVETRAIN);
    l2 = new Spark(RobotMap.L2_DRIVETRAIN);
    r1 = new Spark(RobotMap.R1_DRIVETRAIN);
    r2 = new Spark(RobotMap.R2_DRIVETRAIN);

    lMotor = new SpeedControllerGroup(l1, l2);
    rMotor = new SpeedControllerGroup(r1,r2);

    mdrive = new DifferentialDrive(lMotor,rMotor);
  }

  public void drive(double speed, double rotation) {
    System.out.println(speed);
    mdrive.curvatureDrive(speed, rotation, true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
