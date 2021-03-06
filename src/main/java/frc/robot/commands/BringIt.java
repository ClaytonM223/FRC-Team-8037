/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class BringIt extends Command {

  public BringIt() { 
    requires(Robot.collection);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftTrigger = Robot.m_oi.GetDriver2RawAxis(RobotMap.LEFT_TRIG2_ID);
    boolean leftbumper =  Robot.m_oi.leftBumper2.get();


    if (leftTrigger > 0.1) {
      Robot.collection.setMotorSpeed(RobotMap.COLLECTION_IN_SPEED);
    } else if (leftbumper) {     
      Robot.collection.setMotorSpeed(RobotMap.COLLECTION_OUT_SPEED);
    } else {
      Robot.collection.setMotorSpeed(0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.wheelOFortune.setWheelSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
